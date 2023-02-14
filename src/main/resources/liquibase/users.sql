--liquibase formatted sql
-- changeset galina:1
CREATE INDEX IF NOT EXISTS name_student ON student(name);
-- changeset galina:2
CREATE INDEX IF NOT EXISTS color_i_name_faculty ON faculty(name,color);