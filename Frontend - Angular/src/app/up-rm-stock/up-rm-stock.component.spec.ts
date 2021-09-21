import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpRmStockComponent } from './up-rm-stock.component';

describe('UpRmStockComponent', () => {
  let component: UpRmStockComponent;
  let fixture: ComponentFixture<UpRmStockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpRmStockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpRmStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
