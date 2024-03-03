package com.project275.travelplaner.service;

import com.project275.travelplaner.entity.LoginInfo;
import com.project275.travelplaner.entity.User;
import com.project275.travelplaner.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public String signup(User user, String date, ModelMap model) throws IOException {
        if (userRepo.findByEmail(user.getEmail()) == null) {
            user.setDob(LocalDate.parse(date));
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
                session.setMaxInactiveInterval(120);
                model.put("trips", user.getTrips());
                return "UserHome";
            }
            else {
                model.put("neg", "Invalid Password");
                return "Login";
            }
        }
    }
}
