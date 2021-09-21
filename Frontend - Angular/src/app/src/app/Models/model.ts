export class ProductModel {
    public productId:number;
	public productName:string;
	public pricePerUnit:number;
	public productDuration:number;
	public productDescription:string;
	
}
export class DistributorModel {
    public distributorId: number;
    public distributorName: string; 
    public location: string ;
    public phoneNumber: string;
    public email: string;
}
export class WarehouseModel{
    public warehouseId:number;
	public warehouseName:string;
	public warehouseLocation:string;
	public personIncharge:string;
	public contactNumber:string;
}
export class ProductOrderModel
{
    orderId:number;
	productName:string;
	distributorId:number;
	warehouseId:number;
	quantity:number;
	pricePerUnit:number;
	totalPrice:number;
	deliveryStatus:string;
	dateOfOrder:Date;
	dateOfDelivery:Date;       
}


export class RawMaterialOrderModel {
	public orderId:number;
	public dateOfOrder:Date;
	public rawMaterialName:string;
	public pricePerUnit:number;
	public delDate:Date;
	public deliveryStatus:string;
	public supplierId:number;
	public warehouseId:number;
	public quantityValue:number;
	public totalPrice:number;
	public quantityUnit:string;
}

export class trackModel{
	public supplierId:number;
	public status:string;
	public startDate:Date;
	public endDate:Date;
}
export class RawMaterialModel {
		public rmsId:number;
		
		public materialName:string;
		
		public pricePerUnit:number;
		
		public duration:string;
		
		public description:string;
		
	}

export class SupplierModel {
    public supplierId: number;
    public supplierName: string; 
    public location: string ; 
    public phoneNumber: string;
    public email: string;
}
