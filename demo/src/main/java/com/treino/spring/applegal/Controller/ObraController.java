package com.treino.spring.applegal.Controller;

import com.treino.spring.applegal.Model.Obra;
import com.treino.spring.applegal.Service.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/obra")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService){
        this.obraService = obraService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Obra>> listarObras(){
        List<Obra> obras = obraService.listarTodasObras();
        return ResponseEntity.ok(obras);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Obra> encontrarObraPorId(@PathVariable Long id) {
        List<Obra> obra = obraService.listarObraPorId(id);
        return obra.stream().map(ResponseEntity::ok).findAny().orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Obra> salvarObra(@RequestBody Obra obra) {
        Obra novaObra = obraService.salvarObra(obra);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaObra);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Obra> atualizarObra(@PathVariable Long id, @RequestBody Obra obraAtualizada) {
        Obra obraAtualizadaSalva = obraService.atualizarObra(id, obraAtualizada);
        return ResponseEntity.ok(obraAtualizadaSalva);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarObra(@PathVariable Long id){
        obraService.deletarObra(id);
        return ResponseEntity.noContent().build();
    }
}
