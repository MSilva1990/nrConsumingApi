package com.br.nrCepConsumingApi.schedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 8000)
  void reportTime(){
      log.info("the time now is {} .",simpleDateFormat.format(new Date()));
  }
}
