package br.com.belezze.belezzeAPIREST.controllers;

import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingCancellationData;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingSchedule;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservas")
@SecurityRequirement(name = "bearer-key")
public class ReservationsRestController {

    @Autowired
    private BookingSchedule schedule;

    @PostMapping
    @Transactional
    public ResponseEntity toSchedule(@RequestBody @Valid BookingScheduleData data) {
        var dto = schedule.toSchedule(data);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancel(@RequestBody @Valid BookingCancellationData data) {
        schedule.cancel(data);
        return ResponseEntity.noContent().build();
    }

}
