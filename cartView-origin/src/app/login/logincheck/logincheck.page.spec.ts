import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogincheckPage } from './logincheck.page';

describe('LogincheckPage', () => {
  let component: LogincheckPage;
  let fixture: ComponentFixture<LogincheckPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogincheckPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogincheckPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
