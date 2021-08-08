# Merhaba,

1 ) projede application.properties src/main/resources altındadır. Orada veritabanı ismi vardır.

2 ) Unit testler src/test dizini altındadır. Testler için ayrıyeten properties dosyası oluşturma gereği duyulmamıştır.

3 ) MVC mimarisine uygun tasarım yapılmıştır. Ana classlar src/main/java klasörü altındadır.

4 ) Projenin kolay  çalıştırması için fat jar buildi yapıldı. Run etmek için için klasörün içerisinde maven build komutu çalıştırıldıktan sonra unit testler çalışır ve jar oluşur, target klasörü içerisine gidilip "java -jar ReadingIsGood-1.0-SNAPSHOT-jar-with-dependencies" komutu uygulanabilir.

5 ) application.properties içerisindeki springdoc.swagger-ui.path keyi denk geldiği değer projenin ayağa kalktığı URL'e eklendiğinde direk swagger'a erişilmiş olur. Swagger'de request tipleri ve response tipleri mevcuttur.
