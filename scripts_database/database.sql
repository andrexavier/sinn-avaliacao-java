ALTER TABLE IF EXISTS "person" DROP CONSTRAINT "fk_person_role";

DROP TABLE IF EXISTS "company";
DROP TABLE IF EXISTS "role";
DROP TABLE IF EXISTS "person";

CREATE TABLE "company" (
"id" serial2 NOT NULL,
"name" varchar(255) NOT NULL,
"cnpj" varchar(20) NOT NULL,
"owner" varchar(255) NOT NULL,
PRIMARY KEY ("id") 
)
WITHOUT OIDS;
CREATE TABLE "role" (
"id" serial2 NOT NULL,
"name" varchar(255),
PRIMARY KEY ("id") 
)
WITHOUT OIDS;
CREATE TABLE "person" (
"id" serial2 NOT NULL,
"name" varchar(255) NOT NULL,
"cpf" varchar(15) NOT NULL,
"role_id" int4 NOT NULL,
"salary" decimal(10,2) NOT NULL,
PRIMARY KEY ("id") 
)
WITHOUT OIDS;

ALTER TABLE "person" ADD CONSTRAINT "fk_person_role" FOREIGN KEY ("role_id") REFERENCES "role" ("id");

INSERT INTO "role" (name) values ('Estagiário'), ('Gerente'), ('Diretor');