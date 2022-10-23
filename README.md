# Web Crawler



Web Crawler para coletar dados do site do Governo na página da Agência Nacional de Saúde (ANS).

<img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLU%C3%8DDO&color=GREEN&style=for-the-badge"/>

## Tarefa 1: Baixar o documento do padrão TISS:

1. O bot deve acessar o site utilizando os recursos aprendidos no Nível ZG, no caso, a HTTPBuilder;
2. Acessar o campo "Espaço do Prestador de Serviços de Saúde";
3. Acessar o campo "TISS - Padrão para Troca de Informação de Saúde Suplementar";
4. Acessar o campo "Padrão TISS Versão Mês/Ano ";
5. Realizar o parser no HTML de modo a obter os elementos da tabela de documentos;
6. Baixar o arquivo de  Componente de Comunicação, na tabela de arquivos do padrão TISS  e salvar em uma pasta de Downloads no mesmo diretório do projeto;

## Tarefa 2: Coletar os dados na tabela:

1. O bot deve acessar o site utilizando os recursos aprendidos no Nível ZG, no caso, a HTTPBuilder;
2. Acessar o campo "Espaço do Prestador de Serviços de Saúde";
3. Acessar o campo "TISS - Padrão para Troca de Informação de Saúde Suplementar";
4. Acessar o campo "Histórico das versões dos Componentes do Padrão TISS";
5. Realizar o parser no HTML de modo a obter os elementos da tabela de documentos;
6. Coletar, na tabela, os dados de competência, publicação e início de vigência a partir da competência de data jan/2016;

## Tarefa 3: Baixar a tabela de erros:

1. O bot deve acessar o site utilizando os recursos aprendidos no Nível ZG, no caso, a HTTPBuilder;
2. Acessar o campo "Espaço do Prestador de Serviços de Saúde";
3. Acessar o campo "TISS - Padrão para Troca de Informação de Saúde Suplementar";
4. Acessar o campo "Tabelas relacionadas";
5. Realizar o parser no HTML de modo a obter os elementos da tabela de documentos;
6. Baixar a "Tabela de erros no envio para a ANS";
