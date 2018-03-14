CREATE TABLE noticia (
    codigo serial,
    titulo VARCHAR(80) NOT NULL,
    data_noticia DATE NOT NULL,
    conteudo VARCHAR(5000),
    font VARCHAR(80) not null,
    primary key (codigo)
); 



INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('Contabilidade', '2017-06-10', 'Distribuição de lucros', 'MDW');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Refis de Temer vai perdoar R$ 62 bilhões, o dobro do previsto', '2017-07-10', 'Distribuição de lucros1', 'Jornal O Estado de São Paulo');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - CPC 47 e a Guerra Fiscal entre estados e municípioso', '2017-08-10', 'Distribuição de lucros3', 'Jota Info');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2017-09-10', 'Distribuição de lucros4', 'Destaques Empresariais');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2017-10-10', 'Distribuição de lucros4', 'Destaques Empresariais');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2017-11-10', 'Distribuição de lucros4', 'Destaques Empresariais');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2017-12-10', 'Distribuição de lucros4', 'Destaques Empresariais');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2018-01-10', 'Distribuição de lucros4', 'Destaques Empresariais');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2018-02-10', 'Distribuição de lucros4', 'Destaques Empresariais');
INSERT INTO noticia (titulo, data_noticia, conteudo, font) values ('TRIBUTÁRIO - Informações Obrigatórias na EFD', '2018-03-10', 'Distribuição de lucros4', 'Destaques Empresariais');
