package com.test.adstracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.adstracking.enums.PictureQuality;
import com.test.adstracking.model.Ad;
import com.test.adstracking.model.Chalet;
import com.test.adstracking.model.Flat;
import com.test.adstracking.model.Garage;
import com.test.adstracking.model.Picture;
import com.test.adstracking.repository.AdRepository;

/**
 * Main app to run the springboot application
 * @IMPORTANT: This code was made for a test not for a production scenario. 
 * Because of time we aren't developing a full produc with the full cylce of Software Engineering. So, we are going to enumerate some important points
 * to take into account if we want to develop a more sophistaced code.
 * 
 * 1- TESTING: in this case we aren't developing Junit because of time. Testing is a must. 
 * 2- Logging: using AOP (Aspects) to have some important loggings in our code, would give some great info in case of "fire ;)"
 * 3- Errors handling: we aren't handling error, like null check and so on. We are aware about that it could be bugs about errors handling.
 * 4- Data optimization: we treating all the ads event if they are treated before, so we should optimize that treatment. Like selecting by a date. 
 * 		Those which was treated before, there is no need to treat them again.
 * 5- Concurrency/(Parallelization): we aren't taking into account high concurrency, for example, we could use streamparallel to gain some time. 
 * 6- High performance: we would say that should be in the hardware and OS about threads handling
 * 7- Memory database: like using cache and trying to study about nosql database, which gives faster access
 * 8- ....
 * 
 * @author Mohamed El Boutahiri
 *
 */

@SpringBootApplication
public class App {

	@Autowired
	private AdRepository adRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

	/**
	 * The dozer bean to map the models to the DTOS.
	 * @return DozerBeanMapper
	 * @throws Exception
	 */
	@Bean
	public DozerBeanMapper getDozer() throws Exception {
		return new DozerBeanMapper();
	}

	/**
	 * Loading data in the database, for testing purposes.
	 */
	@PostConstruct
	public void initData() {

		List<Ad> ads = new ArrayList<>();

		ads.add(new Ad("Este piso es una ganga, compra, compra, COMPRA!!!!!", Collections.<Picture>emptyList(), null,
				null, new Chalet(300L, null)));
		ads.add(new Ad(
				"Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo",
				Arrays.asList(new Picture("http://www.idealista.com/pictures/1", PictureQuality.HD)), null, null,
				new Flat(300L)));
		ads.add(new Ad("", Arrays.asList(new Picture("http://www.idealista.com/pictures/2", PictureQuality.HD)), null,
				null, new Chalet(300L, null)));
		ads.add(new Ad("Ático céntrico muy luminoso y recién reformado, parece nuevo",
				Arrays.asList(new Picture("http://www.idealista.com/pictures/5", PictureQuality.OTHER)), null, null,
				new Flat(300L)));
		ads.add(new Ad("Pisazo,",
				Arrays.asList(new Picture("http://www.idealista.com/pictures/3", PictureQuality.OTHER),
						new Picture("http://www.idealista.com/pictures/8", PictureQuality.HD)),
				null, null, new Flat(300L)));
		ads.add(new Ad("", Arrays.asList(new Picture("http://www.idealista.com/pictures/6", PictureQuality.OTHER)),
				null, null, new Garage(300L)));
		ads.add(new Ad("Garaje en el centro de Albacete", Collections.<Picture>emptyList(), null, null,
				new Garage(300L)));
		ads.add(new Ad(
				"Maravilloso chalet situado en lAs afueras de un pequeño pueblo rural. El entorno es espectacular, las vistas magníficas. ¡Cómprelo ahora!",
				Arrays.asList(new Picture("http://www.idealista.com/pictures/1", PictureQuality.OTHER),
						new Picture("http://www.idealista.com/pictures/7", PictureQuality.OTHER)),
				null, null, new Chalet(300L, null)));
		adRepository.saveAll(ads);

	}

}
