package com.yavirac.logistics_backend_pi.auth.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yavirac.logistics_backend_pi.core.entities.Tour;
import com.yavirac.logistics_backend_pi.core.repositories.TourRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    // Dependency injection
    private final UserRepository userRepository;
    private final TourRepository tourRepository;

    // Save (For use in the Partial Update)
    public User save(User user) {
        return userRepository.save(user);
    };

    // Get All
    public List<User> findAll() {
        return userRepository.findAll();
    };

    // Get By Id
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    };

    // Partial Update
    public ResponseEntity<User> updateById(Long id, User userUpdate) {
        try {
            User userExist = findById(id);
            if (userExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (userUpdate.getFullnames() != null)
                userExist.setLastnames(userUpdate.getFullnames());
            if (userUpdate.getLastnames() != null)
                userExist.setLastnames(userUpdate.getLastnames());
            if (userUpdate.getDni() != null)
                userExist.setDni(userUpdate.getDni());
            if (userUpdate.getPhone() != null)
                userExist.setPhone(userUpdate.getPhone());
            if (userUpdate.getEmail() != null)
                userExist.setEmail(userUpdate.getEmail());
            if (userUpdate.getPassword() != null)
                userExist.setPassword(userUpdate.getPassword());
            if (userUpdate.getAddress() != null)
                userExist.setAddress(userUpdate.getAddress());
            if (userUpdate.getGenre() != null)
                userExist.setGenre(userUpdate.getGenre());
            if (userUpdate.getBloodType() != null)
                userExist.setBloodType(userUpdate.getBloodType());
            if (userUpdate.getBirthday() != null)
                userExist.setBirthday(userUpdate.getBirthday());
            if (userUpdate.getMaritalState() != null)
                userExist.setMaritalState(userUpdate.getMaritalState());
            if (userUpdate.getEmergencyContact() != null)
                userExist.setEmergencyContact(userUpdate.getEmergencyContact());
            if (userUpdate.getEmergencyPhone() != null)
                userExist.setEmergencyPhone(userUpdate.getEmergencyPhone());
            if (userUpdate.getDisease() != null)
                userExist.setDisease(userUpdate.getDisease());
            if (userUpdate.getDisability() != null)
                userExist.setDisability(userUpdate.getDisability());
            if (userUpdate.getEnable() != null)
                userExist.setEnable(userUpdate.getEnable());
            // Save Data
            User userSave = save(userExist);
            return ResponseEntity.ok(userSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };

    // Delete
    public void deleteById(long id) {
        userRepository.deleteById(id);
    };

    // Add User to a Tour
    public void addTourToUser(Long uId, Long tId) throws Exception {
        Optional<User> userOpt = userRepository.findById(uId);
        Optional<Tour> tourOpt = tourRepository.findById(tId);

        if (userOpt.isPresent() && tourOpt.isPresent()) {
            User user = userOpt.get();
            Tour tour = tourOpt.get();

            user.getTours().add(tour);
            userRepository.save(user);
        } else {
            throw new Exception("Usuario o Tour no encontrado");
        }
    };

    // Read tours by User
    public List<Tour> getToursByUser(Long id) {
        return userRepository.findById(id)
                .map(User::getTours)
                .orElseThrow(() -> new UserNotFoundException("Error al cargar Tours por Usuario"));
    };

}
