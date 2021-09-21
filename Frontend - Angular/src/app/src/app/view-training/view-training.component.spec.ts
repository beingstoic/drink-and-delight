import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTrainingComponent } from './view-training.component';

describe('ViewTrainingComponent', () => {
  let component: ViewTrainingComponent;
  let fixture: ComponentFixture<ViewTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
