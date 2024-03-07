package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.LoginInfo;
import com.project275.travelplaner.entity.User;
import com.project275.travelplaner.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public String signup(User user, ModelMap model) throws IOException {
        if (userRepo.findByEmail(user.getEmail()) == null) {
            userRepo.save(user);
            model.put("pos", "Signup Succeed");
            return "Login";
        } else {
            model.put("neg", "Email Should be Unique");
            return "Signup";
        }
    }

    public String login(LoginInfo info, ModelMap model, HttpSession session) {
        User user = userRepo.findByEmail(info.getEmail());
        if (user == null) {
            model.put("neg", "Invalid Email Check and Try Again");
            return "Login";
        } else {
            if (user.getPassword().equals(info.getPassword())){
                model.put("pos", "Login Success");
                session.setAttribute("user", user.getId());
                session.setMaxInactiveInterval(1200);
                model.put("trips", user.getTrips());
                model.put("userName", user.getName());
                return "UserHome";
            }
            else {
                model.put("neg", "Invalid Password");
                return "Login";
            }
        }
    }
}
