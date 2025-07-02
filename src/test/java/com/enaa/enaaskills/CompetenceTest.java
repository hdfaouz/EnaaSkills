package com.enaa.enaaskills;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Mappers.CompetenceMap;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Repositories.CompetenceRepository;
import com.enaa.enaaskills.Services.CompetenceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompetenceTest {
    @Mock
    private CompetenceMap competenceMap;
    @Mock
    private CompetenceRepository competenceRepository;
    @InjectMocks
    private CompetenceService competenceService;

    @Test
    void ajouterCompetence_DevraitRetournerCompetenceDto() {

        CompetenceDto competenceDto = new CompetenceDto();
        competenceDto.setNom("Java Programming");
        competenceDto.setStatutAcquise(false);

        Competence competence = new Competence();
        competence.setNom("Java Programming");
        competence.setStatutAcquise(false);

        Competence savedCompetence = new Competence();
        savedCompetence.setNom("Java Programming");
        savedCompetence.setStatutAcquise(false);

        CompetenceDto expectedDto = new CompetenceDto();
        expectedDto.setNom("Java Programming");
        expectedDto.setStatutAcquise(false);

        when(competenceMap.toEntity(competenceDto)).thenReturn(competence);
        when(competenceRepository.save(competence)).thenReturn(savedCompetence);
        when(competenceMap.toDTO(savedCompetence)).thenReturn(expectedDto);

        CompetenceDto result = competenceService.ajouterCompetence(competenceDto);

        assertNotNull(result);
        assertEquals("Java Programming", result.getNom());
        assertEquals(false, result.isStatutAcquise());
    }

}
