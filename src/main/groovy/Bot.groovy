import groovyx.net.http.HttpBuilder
import groovyx.net.http.optional.Download
import org.jsoup.Jsoup
import com.opencsv.CSVWriter

static def tarefa1() {
    def doc = Jsoup.connect('https://www.gov.br/ans/pt-br/assuntos/prestadores/padrao-para-troca-de-informacao-de-saude-suplementar-2013-tiss/padrao-tiss-2013-setembro-2022').get()
    def table = doc.select('.table.table-bordered').first()
    def tbody = table.select('tbody').first().select('tr')
    for(def arquivo : tbody) {
        if (arquivo.select('td').first().text().matches('Componente de Comunicação')) {
            def urlDownload = arquivo.select('a').first().attr('href')
            downloadFile(urlDownload, 'D:\\Projetos\\gradle\\web-crawler\\src\\downloads\\ComponenteComunicação.zip')
        }
    }
}

static def tarefa2() {
    def doc = Jsoup.connect('https://www.gov.br/ans/pt-br/assuntos/prestadores/padrao-para-troca-de-informacao-de-saude-suplementar-2013-tiss/padrao-tiss-historico-das-versoes-dos-componentes-do-padrao-tiss').get()
    def rows = doc.getElementById('parent-fieldname-text').select('table').first().select('tbody').first().select('tr')
    def lines = []
    for(def row : rows) {
        def celulas = row.select('td')
        def competencia = celulas.first().text()
        def publicacao = celulas[1].text()
        def inicioVigencia = celulas[2].text()
        def ano = 2016
        if (competencia.substring(4) as Integer >= ano) {
            lines.add([competencia, publicacao, inicioVigencia])
        }
    }

    new File('D:\\Projetos\\gradle\\web-crawler\\src\\downloads\\HistoricodeVersões.csv').withWriter( {fileWriter ->
        def csvFileWriter = new CSVWriter(fileWriter) as Object
        String[] headerList = ['Competencia', 'Publicação', 'Inicio de Vigencia']
        csvFileWriter.writeNext(headerList, false)
        for(String[] line : lines) {
            csvFileWriter.writeNext(line)
        }
    })
}

static def tarefa3() {
    def doc = Jsoup.connect('https://www.gov.br/ans/pt-br/assuntos/prestadores/padrao-para-troca-de-informacao-de-saude-suplementar-2013-tiss/padrao-tiss-tabelas-relacionadas').get()
    def urlDownload = doc.select('a.internal-link').first().attr('href')
    downloadFile(urlDownload, 'D:\\Projetos\\gradle\\web-crawler\\src\\downloads\\TabelasErros.xlsx')
}

static def downloadFile(String url, String filePath) {
    File newFile = new File(filePath)
    File file = HttpBuilder.configure({
        request.uri = url
    }).get({
        Download.toFile(delegate, newFile)
    }) as File
    file.createNewFile()
}