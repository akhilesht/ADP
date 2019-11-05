package com.org.adp.onlinecart.service;

import java.util.List;

import com.org.adp.pojo.OrderItem;
import com.org.adp.pojo.SalesOrder;

public class BillingServiceImpl implements IBillingService {
	public void generateBill(SalesOrder so){
		List<OrderItem> orderItemList = so.getOrderItemList();
		if(orderItemList!=null && !orderItemList.isEmpty()){
			int itemNumber = 1;
			String itemNumberHeaderStr = "S.No.";
			String productHeaderStr = "Product Name";
			String quantityHeaderStr = "Qty";
			String rateStr = "Rate";
			String amountWithoutTaxStr = "Amount";
			String taxStr = "Tax";
			String totalAmountStr = "Total";
			System.out.printf("--------------------------------------------------------------------------------------------------\n");
			System.out.printf("%-6s %-40s %-3s %-8s    %-8s    %-8s    %-8s \n",itemNumberHeaderStr, productHeaderStr, quantityHeaderStr, rateStr, amountWithoutTaxStr,taxStr, totalAmountStr);
			System.out.printf("--------------------------------------------------------------------------------------------------\n");
			for(OrderItem oi : orderItemList){
				System.out.printf("%03d    %-40s %02d %08.2f    %08.2f    %08.2f    %08.2f \n",itemNumber, oi.getProduct().getProductName(), oi.getQuantity(), oi.getProduct().getRate(), oi.getTotalPriceWithoutTax(), oi.getTax(), oi.getTotalPriceWithTax());
				itemNumber++;
			}
		}
		System.out.printf("--------------------------------------------------------------------------------------------------\n");
		String totalAmtWithouTaxStr = "Total Amount (without Tax)";
		String totalTaxStr = "Total tax";
		String totalAmtWithTaxStr = "Total Amount (including Tax)";
		System.out.printf("%-30s   %08.2f \n", totalAmtWithouTaxStr, so.getTotalAmountWithoutTax());
		System.out.printf("%-30s   %08.2f \n", totalTaxStr, so.getTotalTax());
		System.out.printf("%-30s   %08.2f \n", totalAmtWithTaxStr, so.getTotalAmountWithTax());
		System.out.printf("--------------------------------------------------------------------------------------------------\n");
	}
}
