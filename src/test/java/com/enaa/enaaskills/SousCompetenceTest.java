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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
}
