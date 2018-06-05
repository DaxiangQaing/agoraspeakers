package org.agoraspeakers.cms.service;

import org.agoraspeakers.cms.dao.UserRepository;
import org.agoraspeakers.cms.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Transactional
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean isExistEmail(String email) {
        Stream userList = userRepository.findByEmailReturnStream(email);

        return userList.count() > 0;
    }

    public boolean isExistUsername(String username) {
        Stream userList = userRepository.findByUsernameReturnStream(username);
        return userList.count() > 0;
    }

    public void addUser(AppUser appUser) {
        userRepository.save(appUser);
    }
}
