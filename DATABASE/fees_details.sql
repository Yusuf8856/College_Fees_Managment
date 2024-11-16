use College;
CREATE TABLE `fees_details` (
  `reciept_no` int NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `roll_no` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `cheque_no` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `dd_no` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `gstin` varchar(255) DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `total_in_words` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `year1` int DEFAULT NULL,
  `year2` int DEFAULT NULL,
  PRIMARY KEY (`reciept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
