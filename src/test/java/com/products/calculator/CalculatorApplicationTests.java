package com.products.calculator;

import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import com.products.calculator.service.ProductPricingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CalculatorApplicationTests {

	@Autowired
	ProductPricingService productPricingService;

	@Test
	public void testFullCartonPrices(){
		//PenguinEars
		var request = getProductPriceRequestDTOPenguinEarsCarton();

		var response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(175).setScale(3), response.getPrice());

		request.setQuantity(2);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(350).setScale(3), response.getPrice());

		request.setQuantity(3);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(472.5).setScale(3), response.getPrice());

		request.setQuantity(4);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(630).setScale(3), response.getPrice());

		//HorseShoe
		request = getProductPriceRequestDTOHorseShoeCarton();

		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(825).setScale(3), response.getPrice());

		request.setQuantity(2);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(1650).setScale(3), response.getPrice());

		request.setQuantity(3);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(2227.5).setScale(3), response.getPrice());

		request.setQuantity(4);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(2970).setScale(3), response.getPrice());

	}

	private ProductPriceRequestDTO getProductPriceRequestDTOPenguinEarsCarton(){
		var request = new ProductPriceRequestDTO();
		request.setProductId("1");
		request.setQuantity(1);
		request.setQuantityType(QuantityType.CARTON);

		return request;
	}

	private ProductPriceRequestDTO getProductPriceRequestDTOHorseShoeCarton(){
		var request = new ProductPriceRequestDTO();
		request.setProductId("2");
		request.setQuantity(1);
		request.setQuantityType(QuantityType.CARTON);

		return request;
	}

}
