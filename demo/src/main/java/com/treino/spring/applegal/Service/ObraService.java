package com.treino.spring.applegal.Service;

import org.springframework.stereotype.Service;
import com.treino.spring.applegal.Model.Obra;
import com.treino.spring.applegal.Repository.ObraRepository;

import java.util.List;

@Service
public class ObraService {
    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> listarTodasObras() {
        return obraRepository.findAll();
    }

    public List<Obra> listarObraPorId(Long id){
        return obraRepository.findById(id).stream().toList();
    }

    public Obra salvarObra(Obra obra){
        return obraRepository.save(obra);
    }

    public void deletarObra(Long id){
        obraRepository.deleteById(id);
    }

    private Obra atualizarCamposObra(Obra obraExistente, Obra obraAtualizada) {
        obraExistente.setNome(obraAtualizada.getNome());
        obraExistente.setSinopse(obraAtualizada.getSinopse());
        obraExistente.setQtd_episodios(obraAtualizada.getQtd_episodios());
        obraExistente.setMedia_avaliacao(obraAtualizada.getMedia_avaliacao());
        obraExistente.setData_lancamento(obraAtualizada.getData_lancamento());
        obraExistente.setTipo(obraAtualizada.getTipo());
        return obraExistente;
    }

    public Obra atualizarObra(Long id, Obra obraAtualizada) {
        List<Obra> obraExistenteOptional = listarObraPorId(id);

        if (!obraExistenteOptional.isEmpty()) {
            Obra obraExistente = obraExistenteOptional.get(0);
            obraExistente = atualizarCamposObra(obraExistente, obraAtualizada);
            return obraRepository.save(obraExistente);
        } else {
            throw new RuntimeException("Obra não encontrada");
        }
    }

}
