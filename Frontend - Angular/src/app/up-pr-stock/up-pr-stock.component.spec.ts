import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpPrStockComponent } from './up-pr-stock.component';

describe('UpPrStockComponent', () => {
  let component: UpPrStockComponent;
  let fixture: ComponentFixture<UpPrStockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpPrStockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpPrStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
