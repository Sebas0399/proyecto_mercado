package com.uce.mercado.service.impl;

import com.uce.mercado.repository.inter.IDestinatarioRepository;
import com.uce.mercado.repository.inter.IGuiaRemisionRepository;
import com.uce.mercado.repository.inter.ITransporteRepository;
import com.uce.mercado.repository.model.Destinatario;
import com.uce.mercado.repository.model.GuiaRemision;
import com.uce.mercado.repository.model.ProductoGuia;
import com.uce.mercado.repository.model.Transporte;
import com.uce.mercado.service.inter.IGuiaRemisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GuiaRemisionServiceImpl implements IGuiaRemisionService {
    @Autowired
    private IGuiaRemisionRepository guiaRemisionRepository;
    @Autowired
    private ITransporteRepository transporteRepository;
    @Autowired
    private IDestinatarioRepository destinatarioRepository;
    @Override
    public GuiaRemision create(GuiaRemision guiaRemision) {
        return this.guiaRemisionRepository.create(guiaRemision);
    }

    @Override
    public Optional<GuiaRemision> read(Integer id) {
        return this.guiaRemisionRepository.read(id);
    }

    @Override
    public void update(GuiaRemision guiaRemision) {
        this.guiaRemisionRepository.update(guiaRemision);
    }

    @Override
    public boolean delete(Integer id) {
        return this.guiaRemisionRepository.delete(id);

    }

    @Override
    public Optional<List<GuiaRemision>> readByNumero(String numero) {
        return this.guiaRemisionRepository.readByNumero(numero);
    }

    @Override
    public Optional<List<GuiaRemision>> getAll() {
        return this.guiaRemisionRepository.getAll();
    }

    @Override
    public GuiaRemision create(String fecha, String cedulaDestinatario, String cedulaTransporte) {
        GuiaRemision guiaRemision = new GuiaRemision();
        Optional<List<Destinatario>> destinatario=this.destinatarioRepository.readByCedula(cedulaDestinatario);
        Optional<Transporte> transporte=this.transporteRepository.readByCedula(cedulaTransporte);
        guiaRemision.setGuiaFecha(fecha);
        guiaRemision.setDestinatario(destinatario.get().get(0));
        guiaRemision.setTransporte(transporte.get());
        this.guiaRemisionRepository.create(guiaRemision);

        return guiaRemision;
    }
}
