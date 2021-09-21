import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackRmComponent } from './track-rm.component';

describe('TrackRmComponent', () => {
  let component: TrackRmComponent;
  let fixture: ComponentFixture<TrackRmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackRmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackRmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
