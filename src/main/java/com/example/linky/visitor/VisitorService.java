package com.example.linky.visitor;

import com.example.linky.visitor.model.VisitorEntity;
import com.example.linky.visitor.model.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Service
public class VisitorService {

    @Autowired private VisitorRepository visitorRepository;

    protected String getUserIp() throws Exception {

        String ip = null;
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-RealIP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    protected String doSecurity(String plainIp) {
        return BCrypt.hashpw(plainIp, BCrypt.gensalt());
    }

    protected boolean isSave(String plainIp) {
        List<VisitorEntity> entities = visitorRepository.findAllByRdt(LocalDate.now());
        for(VisitorEntity item : entities) {
            boolean result = BCrypt.checkpw(plainIp, item.getIp());
            if(result) {
                return false;
            }
        }
        return true;
    }

    public void doSave() throws Exception{
        String plainIp = getUserIp();
        if(!isSave(plainIp)) { return; }
        String encodedIp = doSecurity(plainIp);
        VisitorEntity entity = new VisitorEntity();
        entity.setIp(encodedIp);
        entity.setRdt(LocalDate.now());
        visitorRepository.save(entity);
    }

    public int getVisitorCount() {
        return visitorRepository.findAllByRdt(LocalDate.now()).size();
    }
}
