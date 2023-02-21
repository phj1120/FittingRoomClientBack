package org.plateer.fittingroomclient.common.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.security.dto.CustomUserDetail;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Spring Security 사용자 인가를 위해 필요한 UserDetailsService 구현체
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 사용자 조회하는 로직 추가 필요
//        throw new IllegalAccessError("존재하지 않는 사용자");
        log.info("[Login]: Consumer - {}", username);

        UserDetails userDetails = CustomUserDetail.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode("password"))
                .userNo(1L)
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_CONSUMER")))
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .build();

        return userDetails;

    }
}
