package com.products.calculator.util;

import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.entity.Product;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PricingEngine {

    private PricingEngine(){}

    private static final int CARTON_COUNT_FOR_DISCOUNT = 3;
    private static final BigDecimal CARTON_COUNT_DISCOUNT_AMOUNT = BigDecimal.valueOf(1 - 0.1);
    private static final BigDecimal UNIT_PURCHASE_ADDITIONAL_CHARGE = BigDecimal.valueOf(1.3);

    /**
     * Calculate price for requested quantity
     * @param product selected product
     * @param requestedQuantity user requested quantity
     * @param quantityType {{@link QuantityType}}
     * @return Calculated price
     */
    public static BigDecimal calculatePrice(Product product, Integer requestedQuantity, QuantityType quantityType) {
        if (quantityType.equals(QuantityType.CARTON)) {
            return requestedQuantity >= 3 ?
                    product.getCartonPrice()
                            .multiply(CARTON_COUNT_DISCOUNT_AMOUNT)
                            .multiply(BigDecimal.valueOf(requestedQuantity))
                            .setScale(3, RoundingMode.HALF_EVEN):
                            product.getCartonPrice()
                            .multiply(BigDecimal.valueOf(requestedQuantity))
                            .setScale(3, RoundingMode.HALF_EVEN);
        } else {
            var numberOfCartonsAndSingleUnits = getNumberOfCartonsAndSingleUnits(product, requestedQuantity);
            var cartons = numberOfCartonsAndSingleUnits.getLeft();
            var singleUnits = numberOfCartonsAndSingleUnits.getRight();

            if(cartons >= CARTON_COUNT_FOR_DISCOUNT){
                return product.getCartonPrice().multiply(CARTON_COUNT_DISCOUNT_AMOUNT)
                        .multiply(BigDecimal.valueOf(cartons))
                        .add(product.getCartonPrice()
                                .multiply(BigDecimal.valueOf(1.3))
                                .multiply(BigDecimal.valueOf(singleUnits)))
                                .divide(BigDecimal.valueOf(product.getUnitsPerCarton()))
                                .setScale(3, RoundingMode.HALF_EVEN);
            }
            return product.getCartonPrice().multiply(BigDecimal.valueOf(cartons))
                    .add(product.getCartonPrice()
                            .multiply(UNIT_PURCHASE_ADDITIONAL_CHARGE)
                            .multiply(BigDecimal.valueOf(singleUnits)))
                            .divide(BigDecimal.valueOf(product.getUnitsPerCarton()))
                            .setScale(3, RoundingMode.HALF_EVEN);
        }
    }

    /**
     * Get the number of cartons and single units
     * @param product product for which calculates the price
     * @param requestedQuantity the quantity user buying
     * @return Pair<Cartons, SingleUnits>
     */
    private static Pair<Integer, Integer> getNumberOfCartonsAndSingleUnits(Product product, Integer requestedQuantity) {
        if (requestedQuantity < product.getUnitsPerCarton()) {
            return Pair.of(0, requestedQuantity);
        } else if (requestedQuantity % product.getUnitsPerCarton() == 0) {
            return Pair.of(requestedQuantity / product.getUnitsPerCarton(), 0);
        } else {
            return Pair.of(requestedQuantity / product.getUnitsPerCarton(),
                    requestedQuantity % product.getUnitsPerCarton());
        }
    }
}
