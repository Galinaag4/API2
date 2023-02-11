--liquibase formatted sql
-- changeset galina:1
CREATE INDEX name_student ON student(name);
-- changeset galina:2
CREATE INDEX color_i_name_faculty ON faculty(name,color);