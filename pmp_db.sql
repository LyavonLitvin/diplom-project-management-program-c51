-- MySQL Script generated by MySQL Workbench
-- Sun May  8 17:38:49 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pmp_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pmp_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pmp_db` DEFAULT CHARACTER SET utf8 ;
USE `pmp_db` ;

-- -----------------------------------------------------
-- Table `pmp_db`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`categories` (
  `id` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pmp_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`users` (
  `id` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `first_name` VARCHAR(40) NOT NULL,
  `last_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_user_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `user_login_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pmp_db`.`statuses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`statuses` (
  `id` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `status_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pmp_db`.`priorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`priorities` (
  `id` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pmp_db`.`tasks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`tasks` (
  `id` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  `creator_id` BIGINT(64) NOT NULL,
  `executor_id` BIGINT(64) NOT NULL,
  `category_id` BIGINT(64) NOT NULL,
  `status_id` BIGINT(64) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `priority_id` BIGINT(64) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_task_table_task_category_table1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_task_table_user_table1_idx1` (`executor_id` ASC) VISIBLE,
  INDEX `fk_tasks_users1_idx` (`creator_id` ASC) VISIBLE,
  INDEX `fk_tasks_task_statuses1_idx` (`status_id` ASC) VISIBLE,
  INDEX `fk_tasks_priorities1_idx` (`priority_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `task_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `pmp_db`.`categories` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `executor`
    FOREIGN KEY (`executor_id`)
    REFERENCES `pmp_db`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tasks_users1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `pmp_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tasks_task_statuses1`
    FOREIGN KEY (`status_id`)
    REFERENCES `pmp_db`.`statuses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tasks_priorities1`
    FOREIGN KEY (`priority_id`)
    REFERENCES `pmp_db`.`priorities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pmp_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`roles` (
  `id` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `role_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pmp_db`.`roles_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pmp_db`.`roles_users` (
  `role_id` BIGINT(64) NOT NULL,
  `user_id` BIGINT(64) NOT NULL,
  `creation_date_time` DATETIME(6) NOT NULL,
  `update_date_time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`),
  INDEX `fk_roles_has_users_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_roles_has_users_roles1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_roles_has_users_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `pmp_db`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_users_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `pmp_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
