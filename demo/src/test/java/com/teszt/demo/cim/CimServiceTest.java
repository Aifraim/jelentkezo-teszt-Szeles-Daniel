package com.teszt.demo.cim;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CimServiceTest {

    @Mock
    private CimRepository cimRepository;

    @InjectMocks
    private CimService cimService;

    @Test
    void testFindCimById() {
        Cim cim = new Cim();
        cim.setId(1);
        when(cimRepository.findById(1)).thenReturn(Optional.of(cim));

        Optional<Cim> found = cimService.findCimById(1);

        verify(cimRepository).findById(1);
        assertEquals(1, found.get().getId());
    }

    @Test
    void testSaveCim() {
        Cim cim = new Cim();
        cim.setVaros("Test City");
        when(cimRepository.save(any(Cim.class))).thenReturn(cim);

        Cim created = cimService.saveCim(cim);

        verify(cimRepository).save(cim);
        assertEquals("Test City", created.getVaros());
    }
}
