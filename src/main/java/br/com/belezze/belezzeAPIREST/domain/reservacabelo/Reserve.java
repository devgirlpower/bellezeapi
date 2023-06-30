package br.com.belezze.belezzeAPIREST.domain.reservacabelo;

import br.com.belezze.belezzeAPIREST.domain.cliente.Client;
import br.com.belezze.belezzeAPIREST.domain.profissional.Professional;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Reservas")
@Entity(name = "Reserva")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id")
    private Professional professional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private ReasonCancel reasonCancel;

    public void cancel(ReasonCancel reason) {
        this.reasonCancel = reason;
    }

}
