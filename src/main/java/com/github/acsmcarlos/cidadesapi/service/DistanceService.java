package com.github.acsmcarlos.cidadesapi.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.github.acsmcarlos.cidadesapi.cidades.Cidade;
import com.github.acsmcarlos.cidadesapi.cidades.CidadeRepository;

@Service
public class DistanceService {

  private final CidadeRepository cidadeRepository;
  Logger log = LoggerFactory.getLogger(DistanceService.class);

  public DistanceService(final CidadeRepository cidadeRepository) {
    this.cidadeRepository = cidadeRepository;
  }

  public Double distanceByPointsInMiles(final Long cidade1, final Long cidade2) {
    log.info("nativePostgresInMiles({}, {})", cidade1, cidade2);
    return cidadeRepository.distanceByPoints(cidade1, cidade2);
  }

  public Double distanceByCubeInMeters(Long cidade1, Long cidade2) {
    log.info("distanceByCubeInMeters({}, {})", cidade1, cidade2);
    final List<Cidade> cidadees = cidadeRepository.findAllById((Arrays.asList(cidade1, cidade2)));

    Point p1 = cidadees.get(0).getLocation();
    Point p2 = cidadees.get(1).getLocation();

    return cidadeRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }
}