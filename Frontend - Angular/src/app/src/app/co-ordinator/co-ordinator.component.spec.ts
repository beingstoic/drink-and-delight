import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoOrdinatorComponent } from './co-ordinator.component';

describe('CoOrdinatorComponent', () => {
  let component: CoOrdinatorComponent;
  let fixture: ComponentFixture<CoOrdinatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoOrdinatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoOrdinatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
