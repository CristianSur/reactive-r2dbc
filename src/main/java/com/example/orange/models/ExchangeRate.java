package com.example.orange.models;

import com.example.orange.actions.dto.BaseResponseDTO;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate extends BaseResponseDTO {

    @Id
    private Long id;

    Long currencyId;

    Integer nominal;
    Double rate;
    Timestamp date;

    public ExchangeRate(Long currencyId, Integer nominal, Double rate) {
        this.currencyId = currencyId;
        this.nominal = nominal;
        this.rate = rate;
    }

}
