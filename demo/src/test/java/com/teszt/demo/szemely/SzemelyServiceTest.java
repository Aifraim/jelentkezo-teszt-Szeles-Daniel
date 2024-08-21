package com.teszt.demo.szemely;

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
public class SzemelyServiceTest {

    @Mock
    private SzemelyRepository szemelyRepository;

    @InjectMocks
    private SzemelyService szemelyService;

    @Test
    void testFindSzemelyById() {
        Szemely szemely = new Szemely();
        szemely.setId(1);
        when(szemelyRepository.findById(1)).thenReturn(Optional.of(szemely));

        Optional<Szemely> found = szemelyService.findSzemelyById(1);

        verify(szemelyRepository).findById(1);
        assertEquals(1, found.get().getId());
    }

    @Test
    void testSaveSzemely() {
        Szemely szemely = new Szemely();
        szemely.setNev("Test Person");
        when(szemelyRepository.save(any(Szemely.class))).thenReturn(szemely);

        Szemely created = szemelyService.saveSzemely(szemely);

        verify(szemelyRepository).save(szemely);
        assertEquals("Test Person", created.getNev());
    }
}
