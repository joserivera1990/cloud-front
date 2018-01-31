package com.viagging.core.services;

import com.viagging.core.model.PaseoEcologico;
import com.viagging.rest.dto.PaseoEcologicoDTO;

public interface PaseoEcologicoService {

	PaseoEcologico getPaseoEcologicoById(Integer idPaseoEcologico);

	PaseoEcologico createPaseoEcologico(PaseoEcologico paseoEcologico);

	PaseoEcologico updatePaseoEcologico(PaseoEcologico paseoEcologico);
	
	PaseoEcologico deletePaseoEcologico(Integer idPaseoEcologico);
	
	Integer createPaseoEcologico(PaseoEcologicoDTO paseoEcologico);
}
