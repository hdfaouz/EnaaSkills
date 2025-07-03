package com.enaa.enaaskills.ServiceTest;

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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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


    @Test
    void afficher_DevraitRetournerListeCompetences() {

        Competence competence1 = new Competence();

        competence1.setNom("Java");
        competence1.setStatutAcquise(true);

        Competence competence2 = new Competence();
        competence2.setNom("Spring");
        competence2.setStatutAcquise(false);

        List<Competence> competences = Arrays.asList(competence1, competence2);

        CompetenceDto dto1 = new CompetenceDto();

        dto1.setNom("Java");
        dto1.setStatutAcquise(true);

        CompetenceDto dto2 = new CompetenceDto();
        dto2.setNom("Spring");
        dto2.setStatutAcquise(false);

        List<CompetenceDto> expectedDtos = Arrays.asList(dto1, dto2);


        when(competenceRepository.findAll()).thenReturn(competences);
        when(competenceMap.toDTOs(competences)).thenReturn(expectedDtos);

        List<CompetenceDto> result = competenceService.getAllCompetences();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Java", result.get(0).getNom());
        assertEquals("Spring", result.get(1).getNom());
        assertTrue(result.get(0).isStatutAcquise());
        assertFalse(result.get(1).isStatutAcquise());
    }



}
