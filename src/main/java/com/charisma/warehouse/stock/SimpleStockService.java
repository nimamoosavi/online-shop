package com.charisma.warehouse.stock;

import com.charisma.warehouse.stock.dao.StockRepository;
import com.charisma.warehouse.stock.exceptions.ProductNotFoundException;
import com.charisma.warehouse.stock.exceptions.ProductNotQuantityException;
import com.charisma.warehouse.packing.Item;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SimpleStockService implements IStock{

    private final StockRepository stockRepository;

    private final StockMapper stockMapper;
    @Override
    public long findProductQuantity(long productId) {
        var product = stockRepository.findByProductId(productId).orElseThrow(
                () -> new ProductNotFoundException("Product Not Found")
        );
        return product.getQuantity();
    }

    @Override
    public void putInStock(Stock stock) {
        var product = stockRepository.findByProductId(stock.getProductId());

        if (product.isPresent()){
            var quantity = product.get().getQuantity();
            product.get().setQuantity(quantity+stock.getQuantity());
            stockRepository.save(product.get());
        } else {
            var newProduct = createNewProduct(stock);
            stockRepository.save(newProduct);
        }
    }

    @Override
    public void leftFromStock(long productId, long quantity) {
        var product = stockRepository.findByProductId(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product Not Found")
        );
        if (product.getQuantity()<quantity)
            throw new ProductNotQuantityException("Product has not quantity");

        var productQuantity = product.getQuantity();
        product.setQuantity(productQuantity-quantity);
        stockRepository.save(product);
    }

    @Override
    public void leftFromStock(List<Item> items) {
        items.forEach(x->leftFromStock(x.getProductId(),x.getQuantity()));
    }

    private com.charisma.warehouse.stock.entities.Stock createNewProduct(Stock stock){
        var product = new com.charisma.warehouse.stock.entities.Stock();
        product.setQuantity(stock.getQuantity());
        product.setProductId(stock.getProductId());
        product.setPackingType(stock.getPackingType());
        return product;
    }


}
