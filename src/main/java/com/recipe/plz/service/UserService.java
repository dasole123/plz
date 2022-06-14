package com.recipe.plz.service;

import com.recipe.plz.dto.ResponseDto;
import com.recipe.plz.dto.SignupRequestDto;
import com.recipe.plz.model.Users;
import com.recipe.plz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseDto registerUser(SignupRequestDto Dto) {
        Boolean result = true;
        String err_msg = "사용 가능한 ID 입니다.";
        String email = Dto.getEmail();
        String username = Dto.getUsername();

        //Optional<Users> foundemail = userRepository.findByEmail(email);
        Optional<Users> foundusername = userRepository.findByUsername(username);

        // 회원 ID 중복 확인
//        if (foundemail.isPresent()) {
//            err_msg = "중복된 사용자 ID가 존재합니다.";
//            result = false;
//            return new ResponseDto(result, err_msg, email);
//        }

        if (foundusername.isPresent()) {
            err_msg = "중복된 닉네임이 존재합니다.";
            result = false;
            return new ResponseDto(result, err_msg, username);
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(Dto.getPassword());

        Users user = new Users(email, username, password);
        System.out.println(Dto.getEmail());
        System.out.println(Dto.getUsername());
        userRepository.save(user);

        ResponseDto responseDto = new ResponseDto(result,err_msg,username);
        return responseDto;
    }

//    public Boolean checkUsernameDuplicate(String username) {
//        Users user = userRepository.findByUsername(username).orElse(null);
//
//        try {
//            if (user.getUsername().equals(username)) {
//                return false;
//            }
//        } catch (NullPointerException e) {
//            return true;
//        }
//        return true;
//    }

//    public Boolean checkNameDuplicate(String nickname) {
//        Users user = userRepository.findByNickname(nickname).orElse(null);
//
//        try {
//            if (user.getNickname().equals(nickname)) {
//                return false;
//            }
//        } catch (NullPointerException e) {
//            return true;
//        }
//        return true;
//    }

}
