package uz.avazbek.assignmentsubmissionapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.avazbek.assignmentsubmissionapp.domain.User;
import uz.avazbek.assignmentsubmissionapp.repository.UserRepository;
import uz.avazbek.assignmentsubmissionapp.util.CustomPasswordEncoder;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
   private CustomPasswordEncoder passwordEncoder ;
    @Autowired
    private UserRepository userRepository ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(() -> new UsernameNotFoundException("Mavjud bo`lmagan username "));
    }
}
