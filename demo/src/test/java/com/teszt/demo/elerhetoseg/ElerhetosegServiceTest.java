package com.teszt.demo.elerhetoseg;

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
public class ElerhetosegServiceTest {

    @Mock
    private ElerhetosegRepository elerhetosegRepository;

    @InjectMocks
    private ElerhetosegService elerhetosegService;

    @Test
    void testFindElerhetosegById() {
        Elerhetoseg elerhetoseg = new Elerhetoseg();
        elerhetoseg.setId(1);
        when(elerhetosegRepository.findById(1)).thenReturn(Optional.of(elerhetoseg));

        Optional<Elerhetoseg> found = elerhetosegService.findElerhetosegById(1);

        verify(elerhetosegRepository).findById(1);
        assertEquals(1, found.get().getId());
    }

    @Test
    void testSaveElerhetoseg() {
        Elerhetoseg elerhetoseg = new Elerhetoseg();
        elerhetoseg.setErtek("test@example.com");
        when(elerhetosegRepository.save(any(Elerhetoseg.class))).thenReturn(elerhetoseg);

        Elerhetoseg created = elerhetosegService.saveElerhetoseg(elerhetoseg);

        verify(elerhetosegRepository).save(elerhetoseg);
        assertEquals("test@example.com", created.getErtek());
    }
}
