package com.products.calculator;

import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.dto.ProductPriceRequestDTO;
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
		Assertions.assertEquals("1", response.getProductId());
		Assertions.assertEquals("Penguin-ears", response.getName());
		Assertions.assertEquals(1, response.getUnits());

		request.setQuantity(2);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(350).setScale(3), response.getPrice());

		request.setQuantity(3); //10% Discount should be added
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(472.5).setScale(3), response.getPrice());

		request.setQuantity(4); //10% Discount should be added
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(630).setScale(3), response.getPrice());

		//HorseShoe
		request = getProductPriceRequestDTOHorseShoeCarton();

		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(825).setScale(3), response.getPrice());
		Assertions.assertEquals("2", response.getProductId());
		Assertions.assertEquals("Horseshoe", response.getName());
		Assertions.assertEquals(1, response.getUnits());

		request.setQuantity(2);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(1650).setScale(3), response.getPrice());

		request.setQuantity(3); //10% Discount should be added
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(2227.5).setScale(3), response.getPrice());

		request.setQuantity(4); //10% Discount should be added
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(2970).setScale(3), response.getPrice());

	}

	@Test
	public void testUnitPricesPenguinEars(){
		var request = getProductPriceRequestDTOPenguinEarsUnits();
		var response = productPricingService.calculatePriceByUnits(request);
		//unit price (175*1.3)/20
		Assertions.assertEquals(BigDecimal.valueOf(11.375).setScale(3), response.getPrice());

		request.setQuantity(2);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(22.750).setScale(3), response.getPrice());

		request.setQuantity(19);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(216.125).setScale(3), response.getPrice());

		request.setQuantity(20);//unit 20 is a carton
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(175).setScale(3), response.getPrice());

		request.setQuantity(25);//1 carton and 5 units
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(231.875).setScale(3), response.getPrice());

		request.setQuantity(40);//2 cartons
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(350).setScale(3), response.getPrice());

		request.setQuantity(60);//3 cartons 10% discount
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(472.5).setScale(3), response.getPrice());

		request.setQuantity(65);//3 cartons(10% discount) and 5 units
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(529.375).setScale(3), response.getPrice());
	}

	@Test
	public void testUnitPricesHorseShoe(){
		var request = getProductPriceRequestDTOHorseShoeUnits();
		var response = productPricingService.calculatePriceByUnits(request);
		//unit price (825*1.3)/5
		Assertions.assertEquals(BigDecimal.valueOf(214.5).setScale(3), response.getPrice());

		request.setQuantity(2);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(429).setScale(3), response.getPrice());

		request.setQuantity(4);
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(858).setScale(3), response.getPrice());

		request.setQuantity(5);//unit 5 is a carton
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(825).setScale(3), response.getPrice());

		request.setQuantity(9);//1 carton and 4 units
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(1683).setScale(3), response.getPrice());

		request.setQuantity(10);//2 cartons
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(1650).setScale(3), response.getPrice());

		request.setQuantity(15);//3 cartons 10% discount
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(2227.5).setScale(3), response.getPrice());

		request.setQuantity(19);//3 cartons(10% discount) and 4 units
		response = productPricingService.calculatePriceByUnits(request);
		Assertions.assertEquals(BigDecimal.valueOf(3085.5).setScale(3), response.getPrice());
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

	private ProductPriceRequestDTO getProductPriceRequestDTOPenguinEarsUnits(){
		var request = new ProductPriceRequestDTO();
		request.setProductId("1");
		request.setQuantity(1);
		request.setQuantityType(QuantityType.UNIT);

		return request;
	}

	private ProductPriceRequestDTO getProductPriceRequestDTOHorseShoeUnits(){
		var request = new ProductPriceRequestDTO();
		request.setProductId("2");
		request.setQuantity(1);
		request.setQuantityType(QuantityType.UNIT);

		return request;
	}

}
