package com.Proje.demo.services.impl;

import com.Proje.demo.email.MailService;
import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.entity.ReservationInfo;
import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.model.MailStructure;
import com.Proje.demo.repository.ReservationRepository;
import com.Proje.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final UserServiceImpl userService;
    private final ReservationRepository reservationRepository;

    @Autowired
    private final MailService emailService;

    public ReservationServiceImpl(UserServiceImpl userService, ReservationRepository reservationRepository, MailService emailService) {
        this.userService = userService;
        this.reservationRepository = reservationRepository;
        this.emailService = emailService;
    }

    @Override
    public ReservationInfo createReservation(ReservationInfo reservation) {
        // Burada gerekli doğrulamaları yapabilirsiniz, örneğin kullanıcı ve lokasyon kontrolü gibi
        // Ayrıca diğer işlemler de burada gerçekleştirilebilir

        // Örnek olarak sadece rezervasyonun kaydedilmesi:
        ReservationInfo savedReservation = reservationRepository.save(reservation);

        // Kullanıcıya mail gönderme işlemi
        sendConfirmationMail(savedReservation);

        return savedReservation;
    }

    @Override
    public List<ReservationInfo> findAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<ReservationInfo> findById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public ReservationInfo saveReservation(ReservationInfo reservationInfo) {
        return reservationRepository.save(reservationInfo);
    }

    @Override
    public ReservationInfo updateReservation(ReservationInfo reservationInfo) {
        return reservationRepository.save(reservationInfo);
    }


    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    private void sendConfirmationMail(ReservationInfo reservation) {
        // Kullanıcının e-posta adresini al
        String userEmail = getUserEmail(reservation.getUserId());


        emailService.sendMail(userEmail, new MailStructure());
    }

    private String getUserEmail(Long userId) {
        // Kullanıcının e-posta adresini veritabanından almak için
        // findById metodunu kullanarak Optional bir nesne elde ediyoruz
        Optional<UserInfo> userOptional = userService.findById(userId);

        // Eğer kullanıcı bulunamazsa veya e-posta adresi null ise varsayılan bir değer döndürebiliriz
        return userOptional.map(UserInfo::getUsername).orElse("default@example.com");

        // Veya eğer kullanıcı bulunamazsa istisna fırlatabiliriz
        //return userOptional.map(User::getMail).orElseThrow(() -> new IllegalStateException("User not found with id: " + userId));
    }
}
