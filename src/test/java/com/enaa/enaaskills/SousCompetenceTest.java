package com.enaa.enaaskills;

import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Mappers.SousCompetenceMap;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Model.SousCompetence;
import com.enaa.enaaskills.Repositories.CompetenceRepository;
import com.enaa.enaaskills.Repositories.SousCompetenceRepository;
import com.enaa.enaaskills.Services.SousCompetenceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SousCompetenceTest {
    @Mock
    private SousCompetenceMap sousCompetenceMap;

    @Mock
    private SousCompetenceRepository sousCompetenceRepository;

    @Mock
    private CompetenceRepository competenceRepository;

    @InjectMocks
    private SousCompetenceService sousCompetenceService;

    @Test
    void ajouterSousCompetence() {

        SousCompetenceDto dto = new SousCompetenceDto();
        dto.setNom("Programmation orientée objet");
        dto.setStatutValidation(false);
        dto.setCompetenceId(1L);

        Competence competence = new Competence();
        competence.setId(1L);
        competence.setNom("Java");

        SousCompetence sousCompetence = new SousCompetence();
        sousCompetence.setNom("Programmation orientée objet");
        sousCompetence.setStatutValidation(false);

        SousCompetence savedSousCompetence = new SousCompetence();
        savedSousCompetence.setNom("Programmation orientée objet");
        savedSousCompetence.setStatutValidation(false);
        savedSousCompetence.setCompetence(competence);

        SousCompetenceDto expectedDto = new SousCompetenceDto();
        expectedDto.setNom("Programmation orientée objet");
        expectedDto.setStatutValidation(false);
        expectedDto.setCompetenceId(1L);

        when(sousCompetenceMap.toEntity(dto)).thenReturn(sousCompetence);
        when(competenceRepository.findById(1L)).thenReturn(Optional.of(competence));
        when(sousCompetenceRepository.save(sousCompetence)).thenReturn(savedSousCompetence);
        when(sousCompetenceMap.toDTO(savedSousCompetence)).thenReturn(expectedDto);

        SousCompetenceDto result = sousCompetenceService.Ajouter(dto);

        assertNotNull(result);
        assertEquals("Programmation orientée objet", result.getNom());
        assertEquals(false, result.isStatutValidation());
        assertEquals(1L, result.getCompetenceId());
    }

    @Test
    void afficher_DevraitRetournerListeSousCompetences() {
        SousCompetence sousCompetence1 = new SousCompetence();
        sousCompetence1.setNom("POO");
        sousCompetence1.setStatutValidation(true);

        SousCompetence sousCompetence2 = new SousCompetence();
        sousCompetence2.setNom("Collections");
        sousCompetence2.setStatutValidation(false);

        List<SousCompetence> sousCompetences = Arrays.asList(sousCompetence1, sousCompetence2);

        SousCompetenceDto dto1 = new SousCompetenceDto();
        dto1.setNom("POO");
        dto1.setStatutValidation(true);

        SousCompetenceDto dto2 = new SousCompetenceDto();
        dto2.setNom("Collections");
        dto2.setStatutValidation(false);

        List<SousCompetenceDto> expectedDtos = Arrays.asList(dto1, dto2);

        when(sousCompetenceRepository.findAll()).thenReturn(sousCompetences);
        when(sousCompetenceMap.toDTOs(sousCompetences)).thenReturn(expectedDtos);

        List<SousCompetenceDto> result = sousCompetenceService.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("POO", result.get(0).getNom());
        assertEquals("Collections", result.get(1).getNom());
        assertTrue(result.get(0).isStatutValidation());
        assertFalse(result.get(1).isStatutValidation());
    }
}
