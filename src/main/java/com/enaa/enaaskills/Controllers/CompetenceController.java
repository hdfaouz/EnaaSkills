package com.enaa.enaaskills.Controllers;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Services.CompetenceService;
import com.enaa.enaaskills.Services.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/competence")
public class CompetenceController {

    private final CompetenceService competenceService;
    private final ExcelService excelService;

    public CompetenceController(CompetenceService competenceService, ExcelService excelService) {
        this.competenceService = competenceService;
        this.excelService = excelService;
    }

   @PostMapping
    public CompetenceDto ajouterCompetence(@RequestBody CompetenceDto competenceDto){
        return competenceService.ajouterCompetence(competenceDto);
    }

    @GetMapping
    public List<Competence> getAllCompetences(){
        return competenceService.ListCompetence();
    }

    @PutMapping("/{id}")
    public CompetenceDto update(@PathVariable Long id, @RequestBody CompetenceDto dto){
        return competenceService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        competenceService.supprimerCompetence(id);
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        // 1. Définir le type de contenu de la réponse
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        // 2. Créer un nom de fichier dynamique
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=rapportcompetences" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        // 3. Récupérer les données à exporter
        List<Competence> competences = competenceService.ListCompetence();

        // 4. Appeler le service d'export
        excelService.exportCompetencesToExcel(competences, response.getOutputStream());
    }
}
