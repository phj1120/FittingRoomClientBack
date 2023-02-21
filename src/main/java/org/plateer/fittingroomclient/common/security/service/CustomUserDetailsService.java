package org.plateer.fittingroomclient.common.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.security.dto.CustomUserDetail;
import org.plateer.fittingroomclient.consumer.dto.ConsumerDTO;
import org.plateer.fittingroomclient.consumer.service.ConsumerService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


/**
 * Spring Security 사용자 인가를 위해 필요한 UserDetailsService 구현체
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final ConsumerService consumerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ConsumerDTO consumerDTO = consumerService.getConsumerByEmail(username);

        UserDetails userDetails = CustomUserDetail.builder()
                .username(username)
                .password(consumerDTO.getCoPassword())
                .userNo(consumerDTO.getCoNo())
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_CONSUMER")))
                .isEnabled(consumerDTO.isCoStatus())
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .build();

        log.info("[Login]: Consumer - {}", username);
        return userDetails;
    }
}
