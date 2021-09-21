import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterSignupComponent } from './after-signup.component';

describe('AfterSignupComponent', () => {
  let component: AfterSignupComponent;
  let fixture: ComponentFixture<AfterSignupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterSignupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
