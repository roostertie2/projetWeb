package org.projet.projetWeb.services;

import org.projet.projetWeb.model.User;
import org.projet.projetWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean disableUser(int userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setIsActive(false);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
