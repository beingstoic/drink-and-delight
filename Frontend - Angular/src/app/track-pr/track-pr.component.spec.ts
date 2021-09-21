import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackPrComponent } from './track-pr.component';

describe('TrackPrComponent', () => {
  let component: TrackPrComponent;
  let fixture: ComponentFixture<TrackPrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackPrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackPrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
