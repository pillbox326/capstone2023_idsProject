#ids information table

drop table idsinfo;

CREATE TABLE `capstone2023`.`idsinfo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `SrcIP` VARCHAR(20) NULL,
  `DstIP` VARCHAR(20) NULL,
  `SrcPort` VARCHAR(20) NULL,
  `DstPort` VARCHAR(20) NULL,
  `Protocol` VARCHAR(45) NULL,
  `TimeStamp` VARCHAR(45) NULL,
  `FlowDuration` VARCHAR(45) NULL,
  `Label` VARCHAR(45) NULL,
  `DBTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Tot Fwd Pkts` VARCHAR(45) NULL,
  `Tot Bwd Pkts` VARCHAR(45) NULL,
  `TotLen Fwd Pkts` VARCHAR(45) NULL,
  `TotLen Bwd Pkts` VARCHAR(45) NULL,
  `Fwd Pkt Len Max` VARCHAR(45) NULL,
  `Fwd Pkt Len Min` VARCHAR(45) NULL,
  `Fwd Pkt Len Mean` VARCHAR(45) NULL,
  `Fwd Pkt Len Std` VARCHAR(45) NULL,
  `Bwd Pkt Len Max` VARCHAR(45) NULL,
  `Bwd Pkt Len Min` VARCHAR(45) NULL,
  `Bwd Pkt Len Mean` VARCHAR(45) NULL,
  `Bwd Pkt Len Std` VARCHAR(45) NULL,
  `Flow Byts/s` VARCHAR(45) NULL,
  `Flow Pkts/s` VARCHAR(45) NULL,
  `Flow IAT Mean` VARCHAR(45) NULL,
  `Flow IAT Std` VARCHAR(45) NULL,
  `Flow IAT Max` VARCHAR(45) NULL,
  `Flow IAT Min` VARCHAR(45) NULL,
  `Pkt Len Min` VARCHAR(45) NULL,
  `Pkt Len Max` VARCHAR(45) NULL,
  `Pkt Len Mean` VARCHAR(45) NULL,
  `Pkt Len Std` VARCHAR(45) NULL,
  `Pkt Len Var` VARCHAR(45) NULL,
  `FIN Flag Cnt` VARCHAR(45) NULL,
  `SYN Flag Cnt` VARCHAR(45) NULL,
  `RST Flag Cnt` VARCHAR(45) NULL,
  `PSH Flag Cnt` VARCHAR(45) NULL,
  `Active Mean` VARCHAR(45) NULL,
  `Active Std` VARCHAR(45) NULL,
  `Active Max` VARCHAR(45) NULL,
  `Active Min` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE EVENT IF NOT EXISTS `delete_old_data`
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
  DELETE FROM `capstone2023`.`idsinfo`
  WHERE `DBTime` <= DATE_SUB(CURRENT_TIMESTAMP, INTERVAL 14 DAY);

SET GLOBAL event_scheduler = ON;
